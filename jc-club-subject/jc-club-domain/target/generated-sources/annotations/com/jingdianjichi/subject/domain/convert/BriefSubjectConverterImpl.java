package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-12T10:39:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class BriefSubjectConverterImpl implements BriefSubjectConverter {

    @Override
    public SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectBrief subjectBrief = new SubjectBrief();

        subjectBrief.setId( subjectInfoBO.getId() );
        subjectBrief.setSubjectAnswer( subjectInfoBO.getSubjectAnswer() );

        return subjectBrief;
    }
}
