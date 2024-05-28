<h1 align="left">Design Patterns</h1>

###

<p align="left">Welcome to the Design Patterns repository. This repository contains implementations of various design patterns in Java. Each pattern is implemented with clarity to help beginners understand the concepts easily. Below is a list of the design patterns included in this repository along with their descriptions and usage.</p>

###

<h2 align="left">About me</h2>

###

<p align="left">✨ Creating bugs since ...<br>📚 I'm currently learning ...<br>🎯 Goals: ...<br>🎲 Fun fact: ...</p>

###

<h1 align="left">Table of Contents</h1>

###

<h4 align="left">1. Abstract Factory<br>2. Adaptor<br>3. Builder<br>4. Composite<br>5. Decorator<br>6. Facade<br>7. Factory<br>8. Flyweight<br>9. Iterator<br>10. MVC<br>11. Memento<br>12. Observer<br>13. Prototype<br>14. Singleton<br>15. State</h4>

###

<h1 align="left">Abstract Factory</h1>

###

<h2 align="left">Description</h2>

###

<p align="left">The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is particularly useful when you need to create objects that share a common theme or family.</p>

###

<h2 align="left">Problem</h2>

###

<p align="left">In some scenarios, you need to create a set of related objects. For instance, a career counseling application may need to suggest different educational paths based on user input, such as recommending different colleges for B.Tech and M.Tech degrees in various branches of study. The challenge is to ensure that the application can handle different educational paths without changing existing code whenever a new path is added.</p>

###

<h2 align="left">Solution</h2>

###

<p align="left">Declare Interfaces for Products:<br><br>Define an interface for the type of product you want to create. In this case, Career is the product interface.<br>```<br>Copy code<br>interface Career {<br>    void degree();<br>}<br>```</p>

###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" height="40" alt="javascript logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/typescript/typescript-original.svg" height="40" alt="typescript logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/react/react-original.svg" height="40" alt="react logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jest/jest-plain.svg" height="40" alt="jest logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/storybook/storybook-original.svg" height="40" alt="storybook logo"  />
</div>

###
