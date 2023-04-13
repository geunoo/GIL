# Spring MVC

## 정의

Spring에서 **서블릿(Servlet) API를 기반으로 요청을 처리하는 모듈을 Spring-webmvc**라고 하며,
이를 줄여 Spring MVC라고 부르는 것이다.

**클라이언트의 요청을 편하게 처리해주는 웹 프레임워크**이다.

## MVC

Spring MVC에서 MVC는 **Model, View, Controller의 약자**이다. 각 단마다 하는 역할이 나누어져 있다.

### Model

**클라이언트의 요청을 처리하여 나온 데이터**의 결과이다.
**Service 계층에서 비즈니스 로직을 통해 데이터를 처리하고 나온 데이터**라고 볼 수 있다.

### View

Model의 데이터를 **클라이언트(사용자)에게 보여주는 역할**을 수행한다.

**형태**

- SSR(Server Side Rendering)
    - 서버에서 HTML을 파일형식으로 클라이언트에게 전송하는 것
- 문서 ex) Excel, PDF
- CSR(Client Side Rendering
    - Model 데이터를 특정 형식으로 반환 ex) JSON, XML

### Controller

간단히 말해, **Model과 View의 다리 역할을 수행**한다.

클라이언트의 요청을 받아 Model 데이터를 가공하여 View에 전달해준다.

## 동작방식
![1](https://user-images.githubusercontent.com/103028187/222638979-92699215-a72f-46d8-9755-5a5fc834b427.png)


**Spring MVC의 중심에는 Dispatcher Servlet**이 있다.

**Dispatcher Servlet은 Front Controller**라고도 불리며,
**모든 요청과 결과 반환은 DispatcherServlet**을 거치게 된다.

1. 클라이언트에서 요청이 온다.
2. Dispatcher Servlet은 요청된 uri가 controller에 있는지 검색하기 위해 **Handler Mapping에 메서드 호출을 위임**
3. Handler Mapping에서 controller정보 반환
4. **Dispatcher Servlet이 Handler Adapter를 호출**
5. Adapter는 controller에 맞는 비즈니스 로직 실행 
6. 반환된 결과를 **DispatcherServlet을 통해 View에 다시 반환**
