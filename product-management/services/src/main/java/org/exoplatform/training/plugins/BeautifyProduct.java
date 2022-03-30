package org.exoplatform.training.plugins;

import org.exo.training.TextServicePlugin;

public class BeautifyProduct  extends TextServicePlugin {

  @Override
  public String transformText(String s) {
    return " ***** \n "+  s + "\n  ******* \n "  ;
  }
}
