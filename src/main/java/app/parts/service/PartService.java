package app.parts.service;

import app.parts.model.Part;

import java.util.List;

public interface PartService {
    List<Part> allParts(int page);
    void add(Part part);
    void delete(Part part);
    void edit(Part part);
    Part getById(int id);

    int partsCount();
}
