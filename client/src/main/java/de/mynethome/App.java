/*
 ===========================================================================
 @    $Author: b033097 $
 @    $Revision: 1.2 $
 @    $Date: 18.04.13 $
 @
 ===========================================================================
 */
package de.mynethome;

import com.airhacks.afterburner.injection.InjectionProvider;
import de.mynethome.presentation.DemoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opendolphin.core.client.ClientDolphin;
import org.opendolphin.core.client.ClientModelStore;
import org.opendolphin.core.client.comm.ClientConnector;
import org.opendolphin.core.client.comm.HttpClientConnector;
import org.opendolphin.core.client.comm.JavaFXUiThreadHandler;
import org.opendolphin.core.comm.JsonCodec;

/**
 *
 * @author adam-bien.com
 */
public class App extends Application {

  public static ClientDolphin clientDolphin;

  @Override
  public void start(Stage stage) throws Exception {
    DemoView view = new DemoView();
    Scene scene = new Scene(view.getView());
    stage.setTitle("AfterburnerDolphin Demo");
    final String uri = getClass().getResource("app.css").toExternalForm();
    scene.getStylesheets().add(uri);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() throws Exception {
    InjectionProvider.forgetAll();
  }

  @Override
  public void init() throws Exception {
    super.init();
  }

  public static void main(String[] args) {
    clientDolphin = new ClientDolphin();
    clientDolphin.setClientModelStore(new ClientModelStore(clientDolphin));

    ClientConnector connector = createConnector(clientDolphin);
    connector.setUiThreadHandler(new JavaFXUiThreadHandler());
    clientDolphin.setClientConnector(connector);

    launch(args);
  }

  private static ClientConnector createConnector(ClientDolphin clientDolphin) {
    //running real client server mode.
    HttpClientConnector connector = new HttpClientConnector(clientDolphin, "http://10.9.13.109:880/AfterburnerDolphin/applicationServlet");
    connector.setCodec(new JsonCodec());
    return connector;
  }
}