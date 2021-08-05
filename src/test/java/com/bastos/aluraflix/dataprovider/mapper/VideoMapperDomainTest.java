package com.bastos.aluraflix.dataprovider.mapper;

import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import com.bastos.aluraflix.usecase.domain.response.VideoDomainResponse;
import com.bastos.aluraflix.util.video.VideoMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class VideoMapperDomainTest {

    @Spy
    private VideoMapperDomain videoMapperDomain;

    @Test
    public void testToDomainListSuccess() {
        List<VideoDomainResponse> videoDomainResponses = videoMapperDomain.toDomain(VideoMock.mockBuilderVideosEntity());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoDomainResponses.get(0).getId()),
                () -> assertEquals("Homem de Ferro", videoDomainResponses.get(0).getTitulo()),
                () -> assertEquals("Filme numero 1", videoDomainResponses.get(0).getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoDomainResponses.get(0).getUrl()),
                () -> assertEquals(Long.valueOf(1), videoDomainResponses.get(0).getCategoria().getId()),

                () -> assertEquals(Long.valueOf(1), videoDomainResponses.get(1).getId()),
                () -> assertEquals("Homem de Ferro 2", videoDomainResponses.get(1).getTitulo()),
                () -> assertEquals("Filme numero 2", videoDomainResponses.get(1).getDescricao()),
                () -> assertEquals("/homem-de-ferro-2", videoDomainResponses.get(1).getUrl()),
                () -> assertEquals(Long.valueOf(1), videoDomainResponses.get(1).getCategoria().getId())
        );
    }

    @Test
    public void testToDomainListWhenCategoriaNullSuccess() {
        List<VideoDomainResponse> videoDomainResponses =
                videoMapperDomain.toDomain(VideoMock.mockBuilderVideosEntityWhenCategoriaNull());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoDomainResponses.get(0).getId()),
                () -> assertEquals("Homem de Ferro", videoDomainResponses.get(0).getTitulo()),
                () -> assertEquals("Filme numero 1", videoDomainResponses.get(0).getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoDomainResponses.get(0).getUrl()),
                () -> assertNotNull(videoDomainResponses.get(0).getCategoria())
        );
    }

    @Test
    public void testToDomainSuccess() {
        VideoDomainResponse videoDomainResponse = videoMapperDomain.toDomain(VideoMock.mockBuilderVideoEntity());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoDomainResponse.getId()),
                () -> assertEquals("Homem de Ferro", videoDomainResponse.getTitulo()),
                () -> assertEquals("Filme numero 1", videoDomainResponse.getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoDomainResponse.getUrl()),
                () -> assertEquals(Long.valueOf(1), videoDomainResponse.getCategoria().getId())
        );
    }

    @Test
    public void testToEntitySaveSuccess() {
        VideoEntity videoEntity = videoMapperDomain.toEntity(VideoMock.mockBuilderVideoDomainRequest());

        assertAll(
                () -> assertEquals("Homem de Ferro", videoEntity.getTitulo()),
                () -> assertEquals("Filme numero 1", videoEntity.getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoEntity.getUrl()),
                () -> assertEquals(Long.valueOf(1), videoEntity.getCategoria().getId())
        );
    }

    @Test
    public void testToEntityUpdateSuccess() {
        VideoEntity videoEntity = videoMapperDomain.toEntity(VideoMock.mockBuilderVideoDomainResponse());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoEntity.getId()),
                () -> assertEquals("Homem de Ferro", videoEntity.getTitulo()),
                () -> assertEquals("Filme numero 1", videoEntity.getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoEntity.getUrl()),
                () -> assertEquals(Long.valueOf(2), videoEntity.getCategoria().getId())
        );
    }
}
