package ru.hh.nab.todo;

import ru.hh.nab.starter.NabApplication;


public class Main {

  public static void main(String[] args) {
    NabApplication.builder()
      .configureJersey(JerseyConfig.class).bindToRoot()
      .build().run(Config.class);
  }
}
