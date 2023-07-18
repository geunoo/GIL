# Kafka

## Apache Kafka

카프카는 데이터 파이프라인, 스트리밍 분석, 데이터 통합 및 미션 크리티컬 애플리케이션을 위한 `고성능 분산 이벤트 스트리밍 플랫폼`이라고 한다. 

Pub-Sub 모델의 메시지 큐의 한 종류이다.

## Pub-Sub 모델

pub는 발행(Publish), sub는 구독(Subscribe)를 의미한다.

기존의 end-to-end 통신 방식을 보자.

![Untitled](https://github.com/gilgeunwoo/GIL/assets/103028187/01880d2e-e639-405d-83cf-0ee781701734)

user1, user2는 user3, user4에게 데이터를 주기 위해 직접적으로 통신하게 된다.

이렇게 되면 요구하는 user가 많아질수록 각 개체를 일일히 연결해주어야 한다.

이는 확장성이 떨어지게된다.

![Untitled 1](https://github.com/gilgeunwoo/GIL/assets/103028187/3f88d3db-4af5-43c1-bc73-0d77fe3bd62e)


위와 같이 Pub-Sub 모델을 적용하게 된다면 
user1, user2는 데이터를 받을 개체를 정하지 않고, 데이터를 큐에 발행하게 된다.

그리고 저장된 큐에서 user3, user4는 원하는 데이터만을 수신하면 되는 것이다.

## 이벤트 브로커

카프카는 이벤트 브로커이다. 

이벤트 브로커를 설명하기에 앞서 메시지 브로커가 무엇인지 먼저 알 필요가 있다.

### 메시지 브로커

메시지 브로커는 우리가 생각하는 메시지 큐를 말한다. 하지만, 메시지를 수신하게 된다면,
수신된 해당 메시지는 큐에서 `짧은 시간 내에 데이터가 사라진다.`

이벤트 브로커는 메시지브로커의 기능을 가져가고, 거기에 추가로 수신된 메시지를 삭제하지 않고 저장할 수 있다. 

## 구성요소

### Topic

메시지의 용도를 구분할 때 사용된다.

메시지를 전송할때나 소비할때 Topic을 꼭 입력하게 된다.

하나의 Topic은 여러개의 Partition으로 구성된다.

### Partition

분산 처리를 위해 사용된다.

Topic 안에 있는 여러개의 큐라고 생각하면 편하다.

### Offset

Partition에서 메시지를 구분하는 고유 번호이자, 
Consumer가 어디까지 메시지를 읽었는지 저장하는 값이다.

### Consumer

Partition에서 메시지를 가져와 처리하게되는 Subscriber이다.

### **Producer**

메시지를 발행하는 Publisher를 말한다.

메시지를 발행하면 Partition이 받는다.
