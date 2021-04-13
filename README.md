# liveStudy
## 프로젝트 세팅 환경
- os : macOs catalina(v 10.15.7)
- ide : intelli Ultimate (v 2020.3.3)
- jdk : 11.0.9
- build tool : gradle(v 6.8.3)
- spring boot : 2.4.4
## 프로젝트 생성 과정
### Spring
1. IDE에서 spring 프로젝트 생성
1. 의존성 추가 (web,jpa,lombok ...)
1. git ignore 추가
    - 참고 사이트 : https://www.toptal.com/developers/gitignore
### GIT
1. github에서 repository 생성
1. 해당 프로젝트가 존재하는 폴더로 이동
1. 터미널 실행
    - readme 생성 : echo "# liveStudy" >> README.md(선택)
    - git init
    - git add *
    - git commit -m "init"
    - git branch -M main
    - git remote add origin https://github.com/whiteship-s/liveStudy.git
    - git push -u origin main

## GIT commit 규칙
ex) [FEAT] 커밋 메시지
- [FEAT] : 새로운 기능에 대한 커밋
- [FIX] : 버그 수정에 대한 커밋
- [BUILD] : 빌드 관련 파일 수정에 대한 커밋
- [CHORE] : 그 외 자잘한 수정에 대한 커밋
- [CI] : CI관련 설정 수정에 대한 커밋
- [DOCS] : 문서 수정에 대한 커밋
- [STYLE] : 코드 스타일 혹은 포맷 등에 관한 커밋
- [REFACTOR] :  코드 리팩토링에 대한 커밋
- [TEST] : 테스트 코드 수정에 대한 커밋