INSERT INTO T_MASTER_CODE (MASTER_CODE, MASTER_DESC)
VALUES ('테스트1', '테스트1');

INSERT INTO T_COMMON_CODE (CODE, MASTER_CODE, CODE_KR, CODE_DESC, CODE_ORDER, REG_ID, REG_DATE,
                           MOD_ID, MOD_DATE, MOD_COMMENT, STATUS)
VALUES ('테스트1', '테스트1','테스트1','테스트1',1,'테스트',now(), '나',now(),'테스트',true);

