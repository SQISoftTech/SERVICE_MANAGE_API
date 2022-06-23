//package com.sqisoft.mgapi.datasource.mg_service.manageData.vo;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Table(schema = "mg_service", name = "approval_reviewer")
//public class ApprovalReviewerVO {
//
//    @Id
//    private String docId;
//
//    @ManyToOne
//    @JoinColumn(name = "electronicApprovalVO_docId")
//    private ElectronicApprovalVO electronicApprovalVO;
//
//    @Id
//    private String reviewerCd;
//
//    @Column
//    private String reviewDt;
//
//    @Column
//    private String reviewCondition;
//}
