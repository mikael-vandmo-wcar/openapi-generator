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

public final class StoreWireMockClient {

  private volatile Duration timeout = Duration.ofMillis(5000);
  private AtomicInteger priorityCounter = new AtomicInteger(Integer.MAX_VALUE);
  private String pathPrefix;

  public StoreWireMockClient() {
    this("");
  }

  private StoreWireMockClient(String pathPrefix) {
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

  public static StoreWireMockClient withPathPrefix(String pathPrefix) {
    return new StoreWireMockClient(requireNonNull(pathPrefix);
  }

  public static final class DeleteOrderResponseStep {
    private DeleteOrderResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.delete(urlPathMatching("/store/order/{orderId}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public DeleteOrderResponseStep whenDeleteOrder() {
    return new DeleteOrderResponseStep();
  }

  public static final class GetInventoryResponseStep {
    private GetInventoryResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/store/inventory"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public GetInventoryResponseStep whenGetInventory() {
    return new GetInventoryResponseStep();
  }

  public static final class GetOrderByIdResponseStep {
    private GetOrderByIdResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.get(urlPathMatching("/store/order/{orderId}"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public GetOrderByIdResponseStep whenGetOrderById() {
    return new GetOrderByIdResponseStep();
  }

  public static final class PlaceOrderResponseStep {
    private PlaceOrderResponseStep() {}
    public void thenRespondWithInternalServerError() {
      thenRespondWithFailure(500);
    }
    private void thenRespondWithFailure(int status) {
      stubFor(
        com.github.tomakehurst.wiremock.client.WireMock.post(urlPathMatching("/store/order"))
          .atPriority(priorityCounter.getAndDecrement())
          .willReturn(aResponse().withStatus(status)));
    }
  }

  public PlaceOrderResponseStep whenPlaceOrder() {
    return new PlaceOrderResponseStep();
  }

}
