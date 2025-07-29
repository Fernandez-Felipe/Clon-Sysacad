package com.app.auth_service.domain.service;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.domain.port.out.UsuarioRepositoryPort;
import com.app.auth_service.infrastructure.persistance.adapter.DTOS.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    UsuarioRepositoryPort usuarioRepositoryPort;

    @InjectMocks
    private UsuarioService usuarioService;


    @Test
    public void CrearUnUsuario(){

        Usuario user = Usuario.builder()
                .nombre("felipe")
                .legajo(28055)
                .password("123456789")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .nombre("felipe")
                .legajo(28055)
                .build();

        when(usuarioRepositoryPort.saveUsuario(any(Usuario.class))).thenReturn(ResultadoEsperado);

        UserResponse newUser = usuarioService.CrearUsuario(user);

        assertEquals(ResultadoEsperado.getLegajo(),newUser.getLegajo());
        verify(usuarioRepositoryPort).saveUsuario(any(Usuario.class));

    }

    @Test
    public void EncontrarUnUsuarioPorLaId(){

        Usuario user = Usuario.builder()
                .id(1L)
                .nombre("felipe")
                .legajo(28055)
                .password("123456789")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .nombre("felipe")
                .legajo(28055)
                .build();

        when(usuarioRepositoryPort.findById(1L)).thenReturn(ResultadoEsperado);

        UserResponse UsuarioExtraido = usuarioService.EncontrarUsuarioPorLaId(1L);

        assertEquals(user.getLegajo(),UsuarioExtraido.getLegajo());
        verify(usuarioRepositoryPort).findById(1L);

    }

    @Test
    public void EncontrarUsuarioPorElLegajo(){
        Usuario user = Usuario.builder()
                .id(1L)
                .nombre("felipe")
                .legajo(28055)
                .password("123456789")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .legajo(28055)
                .nombre("felipe")
                .build();

        when(usuarioRepositoryPort.findByLegajo(28055)).thenReturn(ResultadoEsperado);

        UserResponse UsuarioExtraido = usuarioService.EncontrarUsuarioPorElLegajo(28055);

        assertEquals(ResultadoEsperado.getLegajo(),UsuarioExtraido.getLegajo());
        verify(usuarioRepositoryPort).findByLegajo(28055);

    }

    @Test
    public void EliminarUsuarioPorLaId(){
        Usuario user = Usuario.builder()
                .id(1L)
                .nombre("felipe")
                .legajo(28055)
                .password("123456789")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .legajo(28055)
                .nombre("felipe")
                .build();

        when(usuarioRepositoryPort.deleteById(1L)).thenReturn(ResultadoEsperado);

        UserResponse UsuarioEliminado = usuarioService.EliminarUsuarioPorLaId(1L);

        assertEquals(ResultadoEsperado.getLegajo(),UsuarioEliminado.getLegajo());

    }

    @Test
    public void EliminarUsuarioPorElLegajo(){
        Usuario user = Usuario.builder()
                .id(1L)
                .nombre("felipe")
                .legajo(28055)
                .password("123456789")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .legajo(28055)
                .nombre("felipe")
                .build();

        when(usuarioRepositoryPort.deleteByLegajo(28055)).thenReturn(ResultadoEsperado);

        UserResponse UsuarioEliminado = usuarioService.EliminarUsuarioPorElLegajo(28055);

        assertEquals(ResultadoEsperado.getLegajo(),UsuarioEliminado.getLegajo());

    }

    @Test
    public void ActualizarUsarioSegunSuId(){

        Usuario UsuarioActualizado = Usuario.builder()
                .id(1L)
                .nombre("carlos")
                .legajo(28055)
                .password("987654321")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .nombre("carlos")
                .legajo(28055)
                .build();

        when(usuarioRepositoryPort.updateUserById(1L, UsuarioActualizado)).thenReturn(ResultadoEsperado);

        UserResponse Result = usuarioService.ActualizarUsuarioPorLaId(1L,UsuarioActualizado);

        assertEquals(Result.getNombre(),ResultadoEsperado.getNombre());
        verify(usuarioRepositoryPort).updateUserById(1L,UsuarioActualizado);

    }

    @Test
    public void ActualizarUnUsuarioSegunSuLegajo(){
        
        Usuario UsuarioActualizado = Usuario.builder()
                .id(1L)
                .nombre("carlos")
                .legajo(28055)
                .password("987654321")
                .build();

        UserResponse ResultadoEsperado = UserResponse.builder()
                .id(1L)
                .nombre("carlos")
                .legajo(28055)
                .build();

        when(usuarioRepositoryPort.updateUserByLegajo(28055, UsuarioActualizado)).thenReturn(ResultadoEsperado);

        UserResponse Result = usuarioService.ActualizarUsuarioPorElLegajo(28055,UsuarioActualizado);

        assertEquals(Result.getNombre(),ResultadoEsperado.getNombre());
        verify(usuarioRepositoryPort).updateUserByLegajo(28055,UsuarioActualizado);

    }

}
