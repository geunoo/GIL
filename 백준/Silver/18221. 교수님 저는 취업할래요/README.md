# [Silver V] 교수님 저는 취업할래요 - 18221 

[문제 링크](https://www.acmicpc.net/problem/18221) 

### 성능 요약

메모리: 4912 KB, 시간: 96 ms

### 분류

기하학, 구현

### 문제 설명

<p>성규는 학점이 높고 알고리즘도 잘 다루는 편이라 매년 알고리즘 대회에 나가 수상을 해오곤 한다. 성규의 꿈은 대학교 4학년 칼졸업을 하고 나서 좋은 대기업에 취직하여 빨리 돈을 버는 것이다.</p>

<p>어느 날, 성규는 전공 수업을 들으러 강의실에 가서 책을 펴고 앉았다. 이 때 교수님이 수업을 시작하시기 전에 한 말씀 하셨다.</p>

<p>교수님: "음... 여기서 내가 눈 여겨 봐온 학생이 있는데... 그래, 성규야. 너 내 랩실에 들어올 생각 없니? 나와 함께 알고리즘에 대한 논문이나 써보자꾸나."</p>

<p>성규는 큰일이다 싶었다. 성규는 졸업하고 싶었다. 대답을 할 생각이 떠오르기 전에 먼저 도망가야겠다는 생각이 들어버렸다!</p>

<p>강의실에는 가로로 N 행, 세로로 N 열, 총 N × N 개의 책상이 있으며, 위쪽에서부터 R 번째 행, 왼쪽에서부터 C 번째 열에 있는 책상의 위치를 (R, C)로 표현한다. 각 책상 자리는 비어있거나, 성규가 아닌 학생 혹은 성규가 앉아있거나, 교수님이 위치해 있다.</p>

<p>도망가는 데 성공하려면, 성규와 교수님의 거리가 5 이상이면서, 교수님과 성규를 꼭짓점으로 하는 축에 평행한 직사각형 안에, 교수님을 제지해줄 성규가 아닌 학생이 세 명 이상 있어야 한다.<br>
단, 교수님과 성규가 같은 행 혹은 같은 열의 책상에 앉아있다면 교수님과 성규를 잇는 선분 상에 성규가 아닌 학생이 세 명 이상 있어야 한다.</p>

<p>이때, 책상 (a, b)와 책상 (c, d) 간의 거리는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msqrt><mjx-sqrt><mjx-surd><mjx-mo class="mjx-sop"><mjx-c class="mjx-c221A TEX-S1"></mjx-c></mjx-mo></mjx-surd><mjx-box style="padding-top: 0.103em;"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44E TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-msup><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo><mjx-script style="vertical-align: 0.289em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msup><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D451 TEX-I"></mjx-c></mjx-mi><mjx-msup><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo><mjx-script style="vertical-align: 0.289em;"><mjx-mn class="mjx-n" size="s"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-script></mjx-msup></mjx-box></mjx-sqrt></mjx-msqrt></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msqrt><mo stretchy="false">(</mo><mi>a</mi><mo>−</mo><mi>c</mi><msup><mo stretchy="false">)</mo><mn>2</mn></msup><mo>+</mo><mo stretchy="false">(</mo><mi>b</mi><mo>−</mo><mi>d</mi><msup><mo stretchy="false">)</mo><mn>2</mn></msup></msqrt></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\sqrt{(a-c)^2 + (b-d)^2}$</span></mjx-container>로 정의한다.</p>

<p>성규는 도망가다가 잡히는 것이 최악이라 판단되어, 도망갈 수가 없는 환경이면 순순히 대학원생의 길로 들어서려고 한다. 이런 성규를 위해 확실히 도망갈 수 있는지 알려주는 프로그램을 작성하자.</p>

### 입력 

 <p>입력의 첫 번째 줄에 자연수 N(7 ≤ N ≤ 1,000) 이 주어진다.</p>

<p>두 번째 줄부터 N개의 각 줄에 0, 1, 2, 5 중 하나의 숫자가 공백으로 구분되어 N개씩 주어진다.</p>

<p>N개의 줄 중 R번째 줄의 C번째 숫자가 d라는 것은 다음과 같은 의미를 가진다:</p>

<ul>
	<li>d = 0: 책상 (R, C)는 빈 자리이다.</li>
	<li>d = 1: 책상 (R, C)는 성규가 아닌 학생이 앉아있다.</li>
	<li>d = 2: 책상 (R, C)는 성규가 앉아있다.</li>
	<li>d = 5: 책상 (R, C)는 교수님이 앉아있다.</li>
</ul>

<p>성규와 교수님은 겹치지 않으며, 각각 정확히 한 자리에만 앉아있다.</p>

### 출력 

 <p>첫 번째 줄에 성규가 교수님에게서 도망칠 수 있으면 1, 그렇지 못하면 0을 출력한다.</p>

