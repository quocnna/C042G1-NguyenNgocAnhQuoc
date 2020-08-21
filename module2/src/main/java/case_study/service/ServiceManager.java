package case_study.service;

import case_study.common.IFile;
import case_study.model.Customer;
import case_study.model.House;
import case_study.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager<T> {
    IFile iFile;

    public ServiceManager(IFile iFile) {
        this.iFile = iFile;
    }
    public void Write(T t) throws Exception{
        iFile.Write(t);
    }

    public List<String[]> Read() throws Exception{
        return iFile.Read();
    }
}
