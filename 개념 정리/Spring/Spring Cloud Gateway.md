# Spring Cloud Gateway

## API Gateway

api gateway는 api 호출과 관련된 작업들을 관리해주는 서비스이다.

Spring Cloud Gateway는 Spring에서 구축할수 있는 api 게이트웨이이다.

여러 api 서버들에 대한 요청을 묶어서 요청 받고 요청된 uri에 해당되는 api서버에게 요청을 핸들링한다.

## 작동 원리

![image](https://github.com/gilgeunwoo/GIL/assets/103028187/4978f8b0-7f99-435f-8654-9d6553e70937)

우선 클라이언트가 gateway server에 요청을 보내면, 

1. Gateway Handler Mapping이 유효한 URI가 존재한다면 Gateway Web Handler에게 보낸다.
2. Gateway Web Handler는 요청을 알맞는 프록시서버에 전송하게 된다.
3. 전송되는 과정에서 gateway server에서 설정한 필터들을 거치게 된다.
4. 또 요청이 종료 된 뒤에도 필터를 거치고 요청을 클라이언트에게 반환하게 된다.
