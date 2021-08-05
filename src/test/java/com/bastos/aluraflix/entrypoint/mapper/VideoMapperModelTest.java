package com.bastos.aluraflix.entrypoint.mapper;

import com.bastos.aluraflix.entrypoint.model.response.VideoModelResponse;
import com.bastos.aluraflix.usecase.domain.request.VideoDomainRequest;
import com.bastos.aluraflix.util.video.VideoMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class VideoMapperModelTest {

    @Spy
    private VideoMapperModel videoMapperModel;

    @Test
    public void testToModelResponseListSuccess() {
        List<VideoModelResponse> videoModelResponses =
                videoMapperModel.toModelResponse(VideoMock.mockBuilderVideosDomainResponse());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoModelResponses.get(0).getId()),
                () -> assertEquals("Homem de Ferro", videoModelResponses.get(0).getTitulo()),
                () -> assertEquals("Filme numero 1", videoModelResponses.get(0).getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoModelResponses.get(0).getUrl()),
                () -> assertEquals(Long.valueOf(2), videoModelResponses.get(0).getCategoria().getId()),

                () -> assertEquals(Long.valueOf(2), videoModelResponses.get(1).getId()),
                () -> assertEquals("Homem de Ferro 2", videoModelResponses.get(1).getTitulo()),
                () -> assertEquals("Filme numero 2", videoModelResponses.get(1).getDescricao()),
                () -> assertEquals("/homem-de-ferro-2", videoModelResponses.get(1).getUrl()),
                () -> assertEquals(Long.valueOf(2), videoModelResponses.get(1).getCategoria().getId())
        );
    }

    @Test
    public void testToModelResponseListWhenCategoriaIsNullSuccess() {
        List<VideoModelResponse> videoModelResponses =
                videoMapperModel.toModelResponse(VideoMock.mockBuilderVideosDomainResponseCategoriaIsNull());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoModelResponses.get(0).getId()),
                () -> assertEquals("Homem de Ferro", videoModelResponses.get(0).getTitulo()),
                () -> assertEquals("Filme numero 1", videoModelResponses.get(0).getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoModelResponses.get(0).getUrl()),

                () -> assertEquals(Long.valueOf(2), videoModelResponses.get(1).getId()),
                () -> assertEquals("Homem de Ferro 2", videoModelResponses.get(1).getTitulo()),
                () -> assertEquals("Filme numero 2", videoModelResponses.get(1).getDescricao()),
                () -> assertEquals("/homem-de-ferro-2", videoModelResponses.get(1).getUrl())
        );
    }

    @Test
    public void testToModelResponseSuccess() {
        VideoModelResponse videoModelResponse =
                videoMapperModel.toModelResponse(VideoMock.mockBuilderVideoDomainResponse());

        assertAll(
                () -> assertEquals(Long.valueOf(1), videoModelResponse.getId()),
                () -> assertEquals("Homem de Ferro", videoModelResponse.getTitulo()),
                () -> assertEquals("Filme numero 1", videoModelResponse.getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoModelResponse.getUrl()),
                () -> assertEquals(Long.valueOf(2), videoModelResponse.getCategoria().getId())
        );
    }

    @Test
    public void testToDomainSaveSuccess() {
        VideoDomainRequest videoDomainRequest =
                videoMapperModel.toDomain(VideoMock.mockBuilderVideoModelRequest());

        assertAll(
                () -> assertEquals("Homem de Ferro", videoDomainRequest.getTitulo()),
                () -> assertEquals("Filme 1", videoDomainRequest.getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoDomainRequest.getUrl()),
                () -> assertEquals(Long.valueOf(1), videoDomainRequest.getCategoria().getId())
        );
    }

    @Test
    public void testToDomainUpdateSuccess() {
        VideoDomainRequest videoDomainRequest =
                videoMapperModel.toDomain(VideoMock.mockBuilderVideoPartialModelRequest());

        assertAll(
                () -> assertEquals("Homem de Ferro", videoDomainRequest.getTitulo()),
                () -> assertEquals("Filme 1", videoDomainRequest.getDescricao()),
                () -> assertEquals("/homem-de-ferro", videoDomainRequest.getUrl())
        );
    }
}
