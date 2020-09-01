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

public final class UserWireMockClient {

  private volatile Duration timeout = Duration.ofMillis(5000);
  private AtomicInteger priorityCounter = new AtomicInteger(Integer.MAX_VALUE);
  private String pathPrefix;

  public UserWireMockClient() {
    this("");
  }

  private UserWireMockClient(String pathPrefix) {
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

  public static UserWireMockClient withPathPrefix(String pathPrefix) {
    return new UserWireMockClient(requireNonNull(pathPrefix);
  }

  public static final class CreateUserResponseStep {
    private CreateUserResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/user"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public CreateUserResponseStep whenCreateUser() {
    return new CreateUserResponseStep();
  }

  public static final class CreateUsersWithArrayInputResponseStep {
    private CreateUsersWithArrayInputResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/user/createWithArray"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public CreateUsersWithArrayInputResponseStep whenCreateUsersWithArrayInput() {
    return new CreateUsersWithArrayInputResponseStep();
  }

  public static final class CreateUsersWithListInputResponseStep {
    private CreateUsersWithListInputResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/user/createWithList"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public CreateUsersWithListInputResponseStep whenCreateUsersWithListInput() {
    return new CreateUsersWithListInputResponseStep();
  }

  public static final class DeleteUserResponseStep {
    private DeleteUserResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.delete(urlPathMatching("/user/{username}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public DeleteUserResponseStep whenDeleteUser() {
    return new DeleteUserResponseStep();
  }

  public static final class GetUserByNameResponseStep {
    private GetUserByNameResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/user/{username}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public GetUserByNameResponseStep whenGetUserByName() {
    return new GetUserByNameResponseStep();
  }

  public static final class LoginUserResponseStep {
    private LoginUserResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/user/login"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public LoginUserResponseStep whenLoginUser() {
    return new LoginUserResponseStep();
  }

  public static final class LogoutUserResponseStep {
    private LogoutUserResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/user/logout"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public LogoutUserResponseStep whenLogoutUser() {
    return new LogoutUserResponseStep();
  }

  public static final class UpdateUserResponseStep {
    private UpdateUserResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.put(urlPathMatching("/user/{username}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public UpdateUserResponseStep whenUpdateUser() {
    return new UpdateUserResponseStep();
  }

}
