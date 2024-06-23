module Kurs {
    requires java.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    exports mvc;
    exports mvc.view;
    exports mvc.model;
    exports mvc.controller;
}