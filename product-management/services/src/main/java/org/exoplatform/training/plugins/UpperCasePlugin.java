package org.exoplatform.training.plugins;

public class UpperCasePlugin extends textUpperCasePlugin {

  @Override
  public String UpperCaseText(String text) {
    return text.toUpperCase();
  }

  @Override
  public String beautifyText(String text) {
    return "\n" + text + "\n";
  }

}
