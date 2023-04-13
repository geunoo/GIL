# Rest, Rest API

## Rest란?

HTTP URI를 통해 자원을 표시하고, HTTP 메서드를 통해 해당 자원에 대한
CRUD Operation을 적용하는 것을 말한다.
네트워크상에서 Server와 Client 사이의 통신 방식이다.
한마디로 **Resource(자원)을 HTTP 메서드를 통해 처리**하는 것이다.

## Rest API란?

**Rest를 잘 준수하도록 구현한 API**를 말한다.

## 예시

**설명으로 하면 복잡하니 예시를 들어보겠다.**

### **예제**

학교 DB에서 특정 학생 정보 조회

### HTTP URI

학생정보 조회니까 자원은 학생, 즉 URI는 `/students`가 되는 것이다.
그리고 `특정` 학생을 조회해야되는 것이니 학생의 DB 키값을 같이 받아줘야한다.
`/students/{student-id}` 이런 식이 되는 것이다.

주의사항은 **행동을 URI에 넣으면 안된다는 것**이다.
`/get/students/{student-id}` X
**HTTP 메서드가 행동을 표현**해주기 때문

### HTTP 메서드

HTTP 메서드란 서버가 행동해야하는 동작을 지정하는 것인데, 종류는 이렇게 된다.

- GET - 리소스 조회
- POST - 리소스 처리, 주로 등록
- PUT - 리소스 전체 수정
- PATCH - 리소스 일부 수정
- DELETE - 리소스 삭제

학생 정보 조회니까 메서드는 `GET` 이 될 것이다.

### 표현

표현은 여러가지 형식이 있는데, 대표적으로는 XML, JSON등이 있다.

JSON으로 표현시

```json
{
    "name":"길근우",
    "number":"2103",
    "birthday":"0412"
    ...
}
```

이런 식으로 반환될 것이다.

# 참 쉽죠?