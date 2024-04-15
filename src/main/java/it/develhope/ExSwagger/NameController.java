package it.develhope.ExSwagger;///*scrivi una applicazione web Spring Boot con:
//NameController dove si mappa il parametro name per:
//restituire il nome alla chiamata GET
//restuiture il nome al contrario (es. da John a nhoJ, usando StringBuilder) alla chiamata POST
//aggungi tutto il necessario per avere una documentazione completa delle endpoint create sopra (nome della chiamata, parametri ecc)
//testare le chiamate del API endpoint usando Postman*/
//package it.develhope.ExSwagger;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NameController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "name", content =
                    {
                            @Content(mediaType = "application/string")
                    })
    })

    @Operation(summary = "method name")
    @GetMapping(path = "/getName")
    public String name(@Parameter(description = "The user's requested parameter") @RequestParam(value = "nome", required = true) String nome) {
        return nome;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " reverse name", content =
                    {
                            @Content(mediaType = "application/string")
                    })
    })


    @Operation(summary = "reverse name")
    @PostMapping(path = "/getReverseName")
    public String reverseName(@Parameter(description = "The parameter name in reverse") @RequestParam(value = "name", required = true) String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
