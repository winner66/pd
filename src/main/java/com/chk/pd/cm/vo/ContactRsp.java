package com.chk.pd.cm.vo;

import com.chk.pd.cm.domain.CmContact;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContactRsp {
    private Company company = new Company();

    List <Area> areas = new ArrayList<>();

    @SneakyThrows
    public void setCompany(CmContact contact) {
        PropertyUtils.copyProperties(company, contact);
    }

    @SneakyThrows
    public void addArea(CmContact contact) {
        Area area = new Area();
        PropertyUtils.copyProperties(area, contact);
        areas.add(area);
    }

    @SneakyThrows
    public void addOffice(String area, CmContact contact) {
        for (Area a : areas) {
            if (StringUtils.equals(a.getName(), area)) {
                Office office = new Office();
                PropertyUtils.copyProperties(office, contact);
                a.getOffices().add(office);
            }
        }
    }


    @Data
    class Company extends CmContact {

    }

    @Data
    class Area extends CmContact {
        List<Office> offices = new ArrayList<>();
    }

    @Data
    class Office extends CmContact{

    }
}
