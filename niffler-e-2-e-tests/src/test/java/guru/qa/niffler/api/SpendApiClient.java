package guru.qa.niffler.api;

import guru.qa.niffler.config.Config;
import guru.qa.niffler.model.CategoryJson;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.PeriodValues;
import guru.qa.niffler.model.SpendJson;
import lombok.SneakyThrows;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpendApiClient {

  private final Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(Config.getInstance().spendUrl())
      .addConverterFactory(JacksonConverterFactory.create())
      .build();

  private final SpendApi spendApi = retrofit.create(SpendApi.class);

  public SpendJson createSpend(SpendJson spend) {
    final Response<SpendJson> response;
    try {
      response = spendApi.addSpend(spend)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }

  public SpendJson editSpend(SpendJson spend) {
    final Response<SpendJson> response;
    try {
      response = spendApi.editSpend(spend)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }

  public SpendJson getSpendById(String id) {
    final Response<SpendJson> response;
    try {
      response = spendApi.getSpendById(id)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }

  public List<SpendJson> getSpendsList(PeriodValues period, CurrencyValues currencyValues) {
    final Response<List<SpendJson>> response;
    try {
      response = spendApi.getSpendsList(period, currencyValues)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }

  public void removeSpends(List<String> ids) {
    final Response<Void> response;
    try {
      response = spendApi.removeSpends(ids)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
  }

  public CategoryJson addCategory(CategoryJson category) {
    final Response<CategoryJson> response;
    try {
      response = spendApi.addCategory(category)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }

  public CategoryJson updateCategory(CategoryJson category) {
    final Response<CategoryJson> response;
    try {
      response = spendApi.updateCategory(category)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }

  public List<CategoryJson> getAllCategories(boolean excludeArchived) {
    final Response<List<CategoryJson>> response;
    try {
      response = spendApi.getAllCategories(excludeArchived)
              .execute();
    } catch (IOException e) {
      throw new AssertionError(e);
    }

    assertEquals(200, response.code());
    return response.body();
  }
}
