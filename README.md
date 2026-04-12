# Practice 2 - Search Algorithms: Maze Solving

Course: Artificial Intelligence (Inteligencia Artificial)
Practice: Practice 2 - Search Algorithms
University: Universidad de Huelva
Year: 2025-2026

> Continuation of [Practice 1 - Tron Navigation Agents](https://github.com/UHU12345L/ai-practice1-tron-navigation-agents)

## 📄 Description

Extension of the Tron grid environment from Practice 1. Instead of reactive or greedy agents,
the agent now calculates the complete route before moving using search algorithms.
The maze has walls (#), a start (E) and an exit (S), and movement costs are asymmetric:
moving up or left costs 2, moving down or right costs 1.

## 🎯 Learning Objectives

- Implementing uninformed search: BFS and DFS
- Implementing informed search: A* with Manhattan heuristic
- Understanding the difference between FIFO, LIFO and priority queue behaviour
- Analysing optimality with non-uniform movement costs
- Designing an admissible custom heuristic

## 🗺️ Maps Available

- MAPA_CALLEJON: Small trap map with a dead-end corridor
- MAPA_GRANDE: Large maze requiring careful navigation
- mapaTexto: Simple custom map for quick testing

## 🤖 Algorithms Implemented

- BusquedaAnchura: BFS using FIFO LinkedList (addLast). Explores level by level. Optimal with uniform costs.
- BusquedaProfundidad: DFS using LIFO LinkedList (addFirst). Explores one full path before backtracking. Not optimal.
- BusquedaA: A* using LinkedList ordered by f(n)=g(n)+h(n) with Manhattan heuristic. Optimal and efficient.
- BusquedaAMejorado: A* with custom weighted Manhattan heuristic that accounts for asymmetric costs.

## 💻 Technologies Used

- Language: Java
- IDE: Eclipse / IntelliJ
- Package: P2

## 🚀 How to Run

1. Clone the repository
2. Open the project in Eclipse or IntelliJ
3. Run `Tron.java`
4. Select the desired map in `main()`
5. Select the desired algorithm in `AgenteBusqueda.java`

## 📁 Project Structure

src/
└── P2/
    ├── Tron.java                  # Main simulation loop
    ├── Entorno.java               # Game engine (reused from Practice 1)
    ├── Nodo.java                  # Search node (position, parent, action, g, h, f)
    ├── Busqueda.java              # Base class with common search logic
    ├── BusquedaAnchura.java       # BFS - FIFO
    ├── BusquedaProfundidad.java   # DFS - LIFO
    ├── BusquedaA.java             # A* - Manhattan heuristic
    ├── BusquedaAMejorado.java     # A* - Custom weighted heuristic
    ├── AgenteBusqueda.java        # Agent that executes the calculated plan
    └── package-info.java

## 🧠 What I Learned

- Difference between BFS (explores all neighbours before going deeper) and DFS (goes deep before backtracking)
- Why BFS is optimal with uniform costs but not with asymmetric costs
- How A* uses f(n)=g(n)+h(n) to explore the most promising nodes first
- What admissibility means and why it matters for optimality
- Using LinkedList as FIFO, LIFO and priority queue depending on insertion method
- Key LinkedList methods: addLast, addFirst, removeFirst, contains, get, add, isEmpty
- Inheritance with extends to avoid code repetition across search classes
