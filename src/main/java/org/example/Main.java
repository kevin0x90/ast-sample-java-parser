package org.example;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(final String[] args) {
        // language=java
        final CompilationUnit cu = StaticJavaParser.parse("""
                public class AstExample {
                    public static int identity(final int a) {
                        return a; 
                    }
                }
                """);

        final var printer = new DotPrinter(true);
        try (final var fileWriter = new FileWriter("ast.dot");
             final var printWriter = new PrintWriter(fileWriter)) {

            printWriter.print(printer.output(cu));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}