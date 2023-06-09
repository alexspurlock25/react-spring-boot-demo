import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
	const [count, setCount] = useState(0)
	const [employees, setEmployees] = useState([])
	const [counters, setCounters] = useState([])

	useEffect(() => {
		// fetch("http://localhost:8080/api/employees")
		// 	.then(response => response.json())
		// 	.then(data => setEmployees(data))

		fetch("http://localhost:8080/api/counters")
			.then(response => response.json())
			.then(data => setCounters(data))
	});

	const increment = (counterId) => {
		fetch(
			`http://localhost:8080/api/counter/${counterId}/increment`, {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify({
					id: counterId
				})
			}
		)
	}

	const addCounter = () => {
		fetch(
			"http://localhost:8080/api/counter", {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify({
					counter: 0
				})
			}
		)
	}
	

	return (
		<>
			<div>
				<a href="https://vitejs.dev" target="_blank">
					<img src={viteLogo} className="logo" alt="Vite logo" />
				</a>
				<a href="https://react.dev" target="_blank">
					<img src={reactLogo} className="logo react" alt="React logo" />
				</a>
			</div>
			<h1>Vite + React + Spring Boot</h1>
			<div className="card">
				<button onClick={addCounter}>Add Counter</button>
				<div>
				{
					counters.map(counter => (
						<button key={counter.id} onClick={() => increment(counter.id)}>
							count is {counter.counter}
						</button>
					))
				}
				</div>
				<p>
					Edit <code>src/App.jsx</code> and save to test HMR
				</p>
			</div>
			<p className="read-the-docs">
				Click on the Vite and React logos to learn more
			</p>
		</>
	)
}

export default App
