module Aplikacija {
    requires javafx.controls;
    requires java.base;
    requires javafx.graphics;
    requires jdk.compiler;
    requires java.desktop;
    exports mvc;
    exports mvc.view;
    exports mvc.controller;
    exports mvc.model;

}