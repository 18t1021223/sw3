package com.example.sw2.configuration;

import com.example.sw2.common.api.v1.response.ErrorRes;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.var;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.ActuatorOperationCustomizer;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author NhatPA
 * @since 12/06/2022 - 20:08
 */
@Configuration
//@OpenAPIDefinition(info = @Info(
//        title = "Test API",
//        version = "0.0.1",
//        termsOfService = "Terms of service",
//        description = "Employees Information"),
//        servers = {
//                @Server(url = "http://localhost:8080", description = "DEV"),
//                @Server(url = "http://localhost:8090", description = "STG")
//        }
//)
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi ApiUser() {
        return GroupedOpenApi.builder()
                .group("User")
//                .pathsToMatch("/api/v1/users/**")
                .addOperationCustomizer(new OperationNotesResourcesReader())
                .packagesToScan("com.example.sw2.api.v1.user")
                .addOpenApiCustomiser(globalOpenApiCustomer())
                .build();
    }

    @Bean
    public GroupedOpenApi ApiAdmin() {
        return GroupedOpenApi.builder()
                .group("Admin")
//                .pathsToMatch("/api/v1/users/**")
                .packagesToScan("com.example.sw2.api.v1.admin")
                .addOpenApiCustomiser(globalOpenApiCustomer())
                .build();
    }

    public OpenApiCustomiser globalOpenApiCustomer() {
        return openApi -> {
            openApi.info(info())
                    .servers(servers());
            openApi.getPaths().values().forEach(this::operations);
        };
    }

    private void operations(PathItem pathItem) {
        pathItem.readOperations().forEach(this::apiResponses);
    }

    /**
     * Set response global
     *
     * @param operation {@link Operation}
     */
    private void apiResponses(Operation operation) {
        ResolvedSchema errorSchema = ModelConverters.getInstance()
                .resolveAsResolvedSchema(new AnnotatedType(ErrorRes.class));
        ApiResponses apiResponses = operation.getResponses();
        // RESPONSE GLOBAL
        apiResponses.addApiResponse("404", new ApiResponse()
                .content(new Content().addMediaType(APPLICATION_JSON_VALUE, new MediaType().schema(errorSchema.schema)))
                .description(HttpStatus.BAD_REQUEST.name())
        );
        apiResponses.addApiResponse("500", new ApiResponse()
                .content(new Content().addMediaType(APPLICATION_JSON_VALUE, new MediaType().schema(errorSchema.schema)))
                .description(HttpStatus.INTERNAL_SERVER_ERROR.name())
        );
    }

    /**
     * Display required role from {@link PreAuthorize}
     */
    private static class OperationNotesResourcesReader extends ActuatorOperationCustomizer {
        @Override
        public Operation customize(Operation operation, HandlerMethod handlerMethod) {
            try {
                var pre = handlerMethod.getMethod().getAnnotation(PreAuthorize.class);
                operation.setDescription(String
                        .format("***Required roles*** %s\n----\n%s", toRoles(pre.value()), operation.getDescription()));
            } catch (Exception ignore) {
            }
            return super.customize(operation, handlerMethod);
        }

        private String toRoles(String s) {
            try {
                if (!ObjectUtils.isEmpty(s)) {
                    return Arrays.stream(s.substring(s.indexOf("(") + 1, s.indexOf(")"))
                                    .replace("'", "")
                                    .split(","))
                            .map(i -> "\n - " + i)
                            .collect(Collectors.joining());
                }
            } catch (Exception e) {
                return "";
            }
            return "";
        }
    }

    public io.swagger.v3.oas.models.info.Info info() {
        return new io.swagger.v3.oas.models.info.Info().title("SpringShop API")
                .description("**Spring shop sample application**")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));
    }

    public List<io.swagger.v3.oas.models.servers.Server> servers() {
        io.swagger.v3.oas.models.servers.Server server = new io.swagger.v3.oas.models.servers.Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("DEV");
        io.swagger.v3.oas.models.servers.Server server2 = new io.swagger.v3.oas.models.servers.Server();
        server2.setUrl("http://localhost:8090");
        server2.setDescription("STG");
        return Arrays.asList(server, server2);
    }


}
