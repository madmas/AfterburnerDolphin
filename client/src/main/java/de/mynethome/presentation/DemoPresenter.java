/*
 ===========================================================================
 @    $Author: b033097 $
 @    $Revision: 1.2 $
 @    $Date: 26.04.13 $
 @
 ===========================================================================
 */
package de.mynethome.presentation;

import de.mynethome.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.opendolphin.binding.JFXBinder;
import org.opendolphin.core.PresentationModel;
import org.opendolphin.core.client.ClientAttribute;
import org.opendolphin.core.client.ClientPresentationModel;
import org.opendolphin.core.client.comm.OnFinishedHandlerAdapter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static de.mynethome.ApplicationConstants.ATT_ATTR_ID;
import static de.mynethome.ApplicationConstants.COMMAND_ID;
import static de.mynethome.ApplicationConstants.PM_APP;

public class DemoPresenter implements Initializable {

  @FXML
  Button button;

  private PresentationModel textAttributeModel;

  public DemoPresenter() {
      textAttributeModel = App.clientDolphin.presentationModel(PM_APP, new ClientAttribute(ATT_ATTR_ID, "Click me!"));
  }


  public void initialize(URL location, ResourceBundle res){
    JFXBinder.bind(ATT_ATTR_ID).of(textAttributeModel).to("text").of(button);
  }

  public void buttonClicked(ActionEvent actionEvent) {
    System.out.println("actionEvent = " + actionEvent);
    App.clientDolphin.send(COMMAND_ID, new OnFinishedHandlerAdapter() {
      @Override
      public void onFinished(List<ClientPresentationModel> presentationModels) {
        textAttributeModel.getAt(ATT_ATTR_ID).rebase();
      }
    });
  }
}
