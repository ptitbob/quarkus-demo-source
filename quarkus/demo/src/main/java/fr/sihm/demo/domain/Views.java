package fr.sihm.demo.domain;

/**
 * @author François Robert
 * LICENCE Apache 2.0
 */
public class Views {

  private Views() {
    // nothing
  }

  public static class Identity {
    private Identity() {
      // nothing
    }
  }

  public static class List extends Identity {
    private List() {
      // nothing
    }
  }

  public static class Details extends List {
    private Details() {
      // nothing
    }
  }
}
