package invalidPackageName;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static java.lang.Objects.requireNonNull;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.VerificationException;
import com.github.tomakehurst.wiremock.client.WireMock;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public final class PetWireMockClient {

  private volatile Duration timeout = Duration.ofMillis(5000);
  private AtomicInteger priorityCounter = new AtomicInteger(Integer.MAX_VALUE);
  private String pathPrefix;

  public PetWireMockClient() {
    this("");
  }

  private PetWireMockClient(String pathPrefix) {
    this.pathPrefix = pathPrefix;
  }

  public Duration timeout() {
    return timeout;
  }

  public void timeout(Duration timeout) {
    this.timeout = timeout;
  }

  public String urlPrefix() {
    return urlPrefix;
  }

  public static PetWireMockClient withPathPrefix(String pathPrefix) {
    return new PetWireMockClient(requireNonNull(pathPrefix);
  }

  public static final class AddPetResponseStep {
    private AddPetResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/pet"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public AddPetResponseStep whenAddPet() {
    return new AddPetResponseStep();
  }

  public static final class DeletePetResponseStep {
    private DeletePetResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.delete(urlPathMatching("/pet/{petId}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public DeletePetResponseStep whenDeletePet() {
    return new DeletePetResponseStep();
  }

  public static final class FindPetsByStatusResponseStep {
    private FindPetsByStatusResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/pet/findByStatus"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public FindPetsByStatusResponseStep whenFindPetsByStatus() {
    return new FindPetsByStatusResponseStep();
  }

  public static final class FindPetsByTagsResponseStep {
    private FindPetsByTagsResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/pet/findByTags"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public FindPetsByTagsResponseStep whenFindPetsByTags() {
    return new FindPetsByTagsResponseStep();
  }

  public static final class GetPetByIdResponseStep {
    private GetPetByIdResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/pet/{petId}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public GetPetByIdResponseStep whenGetPetById() {
    return new GetPetByIdResponseStep();
  }

  public static final class UpdatePetResponseStep {
    private UpdatePetResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.put(urlPathMatching("/pet"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public UpdatePetResponseStep whenUpdatePet() {
    return new UpdatePetResponseStep();
  }

  public static final class UpdatePetWithFormResponseStep {
    private UpdatePetWithFormResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/pet/{petId}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public UpdatePetWithFormResponseStep whenUpdatePetWithForm() {
    return new UpdatePetWithFormResponseStep();
  }

  public static final class UploadFileResponseStep {
    private UploadFileResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/pet/{petId}/uploadImage"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public UploadFileResponseStep whenUploadFile() {
    return new UploadFileResponseStep();
  }

}
