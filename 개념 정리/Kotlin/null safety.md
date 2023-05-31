# kotlin null safety

## ****Null Safety****

코틀린이 나오게된 이유중 하나이기도 하다. 
기존에 자바를 이용할때는, NullPointerException 그러니까 NPE가 많이 일어났다. 
자바는 널에대한 안정성이 떨어지기 때문에 이를 해결한 것이 Kotlin이다.

그 방식을 보자.

## Nullable Type

기본적으로 코틀린에서 선언된 변수는 널 참조가 불가능하다.

```kotlin
val a: String = null //컴파일 에러
```

해당 변수는 널이 들어갈 수 없기때문에 컴파일 에러가 나는 것이다.

하지만 ?를 타입 뒤에 붙인다면 널을 참조할 수 있게 된다.

```kotlin
val b: String? = null // 가능
```

이렇게!

## Safe Calls

만약 그냥 선언된 변수, 그러니까 위에서 선언한 `a`같은 변수는 널이 절대 들어갈 수 없다. 
그래서 a의 프로퍼티나 메서드에 접근해도 아무런 문제가 없다.

```kotlin
val i = a.length // 가능
```

하지만 Nullable Type으로 선언된 변수 `b`같은 경우는 그냥 접근하게되면 컴파일 오류가 난다.

```kotlin
val l = b.length // 컴파일 에러
```

b는 널을 참조할 수도 있다고 명시해줬기 때문에(?를 붙임) 그냥 참조하게 된다면 NPE의 가능성이 있기 때문에 컴파일 에러가 나는 것이다. 그래서 안전하게 참조하기 위해서 safe call을 사용하게 된다.

```kotlin
val l: Int? = b?.length // 가능
```

만약 b가 널이라면 널이 반환 된다. 타입 뒤에 ?를 붙인 이유는 b에서 null이 반환 될 수도 있기때문이다.

## ****Elvis Operator****

엘비스 연산자는 `if (b != null) x else y`라고 보면 된다. 널이 아닐때는 해당 값을 반환, 널이면 `?:` 뒤에있는 값을 반환하게 하는 것이다.

```kotlin
val l = b?.length ?: 0 // 가능
```

b가 널이면 `b?.length`에서 널이 반환되고, 그러면 변수 `l`에는 0이 들어가는 것이다. 

그럼 위의 예제에서 작성한 `l`의 아쉬운 점인 nullable type인 점을 해결할 수 있는것이다.

## ****!! Operator****

!! 연산자는 nullable type 변수를 사용할때, 해당 변수는 절대 null이 들어올수 없음을 **명시**해주는 것이다.

```kotlin
val l = b!!.length // 가능
```

변수 b는 nullable type이기 때문에 null이 들어갈 수 있다.
만약 위의 코드를 작성했는데 b에 null이 들어간다면 NPE가 터지게 된다.

왠만하면 사용하지 말자.