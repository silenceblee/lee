drop table if exists SYS_DICT_TYPE;

/*==============================================================*/
/* Table: SYS_DICT_TYPE                                         */
/*==============================================================*/
create table SYS_DICT_TYPE
(
   DICT_TYPE            VARCHAR(10) not null comment '字典类型',
   DICT_DESC            VARCHAR(200) comment '字典类型描述',
   REMARK               VARCHAR(500) comment '备注',
   primary key (DICT_TYPE)
);

alter table SYS_DICT_TYPE comment '字典类型';


drop table if exists SYS_DICT_ENTRY;

/*==============================================================*/
/* Table: SYS_DICT_ENTRY                                        */
/*==============================================================*/
create table SYS_DICT_ENTRY
(
   DICT_TYPE            VARCHAR(10) not null comment '字典类型',
   DICT_CODE            VARCHAR(10) not null comment '字典编码',
   DICT_NAME            VARCHAR(200) comment '字典名称',
   DICT_ORDER           INTEGER comment '显示序号',
   REMARK               VARCHAR(200) comment '备注',
   primary key (DICT_TYPE, DICT_CODE)
);

alter table SYS_DICT_ENTRY comment '字典集合';