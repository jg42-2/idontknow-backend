package utec.idontknowbackend.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDTO {

    private String token;

    @Builder.Default
    private String tipo = "Bearer";

    private String nombre;
    private String email;
    private String role;
}