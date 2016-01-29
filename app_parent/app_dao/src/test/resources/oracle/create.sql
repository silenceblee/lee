create table SYS_DICT_TYPE 
(
   DICT_TYPE            VARCHAR(10)          not null,
   DICT_DESC            VARCHAR(200),
   REMARK               VARCHAR(500),
   constraint PK_SYS_DICT_TYPE primary key (DICT_TYPE)
);
comment on table SYS_DICT_TYPE is
'字典类型';

comment on column SYS_DICT_TYPE.DICT_TYPE is
'字典类型';

comment on column SYS_DICT_TYPE.DICT_DESC is
'字典类型描述';

comment on column SYS_DICT_TYPE.REMARK is
'备注';


create table SYS_DICT_ENTRY 
(
   DICT_TYPE            VARCHAR(10)          not null,
   DICT_CODE            VARCHAR(10)          not null,
   DICT_NAME            VARCHAR(200),
   DICT_ORDER           INTEGER,
   REMARK               VARCHAR(200),
   constraint PK_SYS_DICT_ENTRY primary key (DICT_TYPE, DICT_CODE)
);

comment on table SYS_DICT_ENTRY is
'字典集合';

comment on column SYS_DICT_ENTRY.DICT_TYPE is
'字典类型';

comment on column SYS_DICT_ENTRY.DICT_CODE is
'字典编码';

comment on column SYS_DICT_ENTRY.DICT_NAME is
'字典名称';

comment on column SYS_DICT_ENTRY.DICT_ORDER is
'显示序号';

comment on column SYS_DICT_ENTRY.REMARK is
'备注';
