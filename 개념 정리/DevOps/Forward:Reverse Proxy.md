# Forward/Reverse Proxy

포워드 프록시와 리버스 프록시는 프록시서버가 어디에 위치하는 지에 따라 갈리게 된다.

## Forward Proxy

![Forward Proxy와 Reverse Proxy 차이점](https://blog.kakaocdn.net/dn/Pbhvn/btqBzj4CWaB/LVl1kFgdRPYq3DLbEeGn10/img.jpg)

포워드 프록시는 위와 같이 인터넷을 사이에 두고 클라이언트 쪽에 존재하는 프록시 서버를 말하게 된다.

클라이언트가 서버에 접근하고자 할때, 포워드 프록시가 해당 요청을 서버에 대신 보내고, 데이터를 가지고온다.

흔히 말하는 프록시 서버가 포워드 프록시라고 한다.

## Reverse Proxy

![What is a Reverse Proxy Server | Reverse vs. Forward Proxy | CDN Guide |  Imperva](https://www.imperva.com/learn/wp-content/uploads/sites/13/2019/01/reverse-proxy-02-1.jpg)

리버스 프록시는 거꾸로 서버쪽에 존재하는 프록시 서버이다.

서버라고 부르는것은 주로 WAS가 될텐데, 이 WAS가 직접 노출되게 된다면, 보안상의 문제가 생긴다.

만약 WAS가 해킹된다면 WAS에 연결되어있는 DB서버까지 공격당할 가능성이 있기때문에,
이러한 공격들을 리버스 프록시로 걸러주고, WAS를 은닉하는 것이다.

