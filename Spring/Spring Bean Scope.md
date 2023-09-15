# Spring Bean Scope

Spring Bean Scope를 알기 전에, Spring Bean에 대해 알 필요가 있다.

# Spring Bean이란?

Spring IoC 컨테이너가 관리해주는 Java 객체라고 볼 수 있다. 

제어의 역전을 수행하기 위해 IoC 컨테이너에 등록된 객체이다.

등록된 Bean은 IoC 컨테이너가 관리해준다.

# Bean Scope

bean이 사용되는 범위라고 정의되어있긴 한데, 
그냥 bean이 어떤 bean인지에 대한 것이라고 이해하면 편하다.

### singleton

싱글톤 패턴을 적용시킨 빈으로, 이 빈은 spring 컨테이너가 실행될때 딱 한번만 생성되고,
그 생성된 객체를 돌려쓰는 것이다. 

빈 등록시에 기본값이며, 아무 설정을 하지 않으면 이 scope가 적용된다.

주로 상태값을 가지지 않고, 단순 로직만 있는 경우 사용하게 된다.
ex) Service 클래스

### prototype

프로토타입은 java에서 new를 이용해 객체를 생성하는 것처럼, 
호출 될때마다 객체를 생성하는 scope이다. 

생성 이후엔 컨테이너가 관리하지 않는다.

## web scope

### request

Http 요청이 들어올때부터 종료될때 까지 유지되는 scope이다. 

### application

servlet context와 동일한 생명주기를 가지는 scope.