INSERT IGNORE INTO T_MASTER_CODE (MASTER_CODE, MASTER_DESC)
VALUES ('STUDY', '스터디의 주제를 확인합니다.'),('SITE','어떤 사이트의 블로그인지 확인합니다.'),('EMOJI','이모지를 확인합니다.');

INSERT IGNORE INTO T_COMMON_CODE (CODE, MASTER_CODE, CODE_KR, CODE_DESC, CODE_ORDER, REG_ID, REG_DATE,
                           MOD_ID, MOD_DATE, MOD_COMMENT, STATUS)
-- 코드 설명 : (MASTER CODE)_ (CODE 순번 1-100) (시즌 1-10) (코드 인덱스 0-1000)
-- CODE 순번 : STUDY 1번 SITE 2번 EMOJI 3번 ...
-- 시즌 : 스터디 시즌 10까지 입력가능 (스터디를 제외한 나머지는 0으로) ...
-- 코드 인덱스 : 각 코드의 순번에 맞게
-- ex) 시즌1 15번째 스터디 =>  STUDY_110015

VALUES
 ('STUDY_110001', 'STUDY','1','시즌1 1주차의 스터디',1,'yonghun',now(),'yonghun',now(), null ,true),
 ('STUDY_110002', 'STUDY','2','시즌1 2주차의 스터디',2,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110003', 'STUDY','3','시즌1 3주차의 스터디',3,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110004', 'STUDY','4','시즌1 4주차의 스터디',4,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110005', 'STUDY','5','시즌1 5주차의 스터디',5,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110006', 'STUDY','6','시즌1 6주차의 스터디',6,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110007', 'STUDY','7','시즌1 7주차의 스터디',7,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110008', 'STUDY','8','시즌1 8주차의 스터디',8,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110009', 'STUDY','9','시즌1 9주차의 스터디',9,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110010', 'STUDY','10','시즌1 10주차의 스터디',10,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110011', 'STUDY','11','시즌1 11주차의 스터디',11,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110012', 'STUDY','12','시즌1 12주차의 스터디',12,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110013', 'STUDY','13','시즌1 13주차의 스터디',13,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110014', 'STUDY','14','시즌1 14주차의 스터디',14,'yonghun',now(), 'yonghun',now(), null ,true),
 ('STUDY_110015', 'STUDY','15','시즌1 15주차의 스터디',15,'yonghun',now(), 'yonghun',now(), null ,true),

 ('SITE_200001', 'SITE','NAVER','네이버',16,'yonghun',now(), 'yonghun',now(), null ,true),
 ('SITE_200002', 'SITE','TISTORY','티스토리',17,'yonghun',now(), 'yonghun',now(), null ,true),
 ('SITE_200003', 'SITE','GITHUB','깃 허브',18,'yonghun',now(), 'yonghun',now(), null ,true),
 ('SITE_200004', 'SITE','NOTION','노션',19,'yonghun',now(), 'yonghun',now(), null ,true),
 ('SITE_200005', 'SITE','VELOG','벨로그',20,'yonghun',now(), 'yonghun',now(), null ,true),

 ('EMOJI_300001', 'EMOJI','HEART','하트',21,'yonghun',now(), 'yonghun',now(), null ,true),
 ('EMOJI_300002', 'EMOJI','PLUS_ONE','좋아요',22,'yonghun',now(), 'yonghun',now(), null ,true);


