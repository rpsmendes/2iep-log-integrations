package com.iep.log.integrations.service;


import org.marsik.ham.adif.AdiReader;
import org.marsik.ham.adif.Adif3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdiService {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(this.getClass()));

    private final AdiReader reader;

    public AdiService() {
        reader = new AdiReader();
    }

    public Optional<Adif3> readRecord(String input) {
        try {
            return reader.read(bufferedReaderFrom(input));
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Unable to read Adif record from input.", input);
            return Optional.empty();
        }
    }

    private BufferedReader bufferedReaderFrom(String input) {
        return new BufferedReader(new StringReader(input));
    }
}
