package app.parts.service;

import app.parts.dao.PartDao;
import app.parts.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartServiceImp implements PartService {
    private PartDao partDao;


    @Autowired
    public void setPartDao(PartDao partDao) {
        this.partDao = partDao;
    }

    @Override
    @Transactional
    public List<Part> allParts(int page) {
        return partDao.allParts(page);
    }

    @Override
    @Transactional
    public void add(Part part) {
        partDao.add(part);
    }

    @Override
    @Transactional
    public void delete(Part part) {
        partDao.delete(part);
    }

    @Override
    @Transactional
    public void edit(Part part) {
        partDao.edit(part);
    }

    @Override
    @Transactional
    public Part getById(int id) {
        return partDao.getById(id);
    }

    @Override
    @Transactional
    public int partsCount() {
      return partDao.partsCount();
    }
}
