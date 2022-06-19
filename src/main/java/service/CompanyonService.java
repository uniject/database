package service;

import controller.CompanyonController;
import mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.Project;

import java.util.List;

@Service
public class CompanyonService  implements CompanyonServiceImpl {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getAllProject() {
        return projectMapper.getAllProject();
    }
}
