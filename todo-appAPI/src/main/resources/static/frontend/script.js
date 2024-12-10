const apiUrl = 'http://localhost:8080/api/todos';

// Add a new To-Do
async function addTodo() {
    const task = document.getElementById('todoInput').value;
    if (!task) return alert('Please enter a task!');

    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(task),
    });

    if (response.ok) {
        document.getElementById('todoInput').value = ''; // Clear input field
        loadToDos(); // Refresh the to-do list
    } else {
        alert('Failed to add to-do');
    }
}

document.getElementById('addTodoButton').addEventListener('click', addTodo);

// Add task on Enter key press
document.getElementById('todoInput').addEventListener('keydown', (event) => {
    if (event.key === 'Enter') {
        addTodo();
    }
});

// Load all To-Dos
async function loadToDos() {
    const response = await fetch(apiUrl);
    const todos = await response.json();

    const todoList = document.getElementById('todoList');
    todoList.innerHTML = ''; // Clear existing list

    todos.forEach(todo => {
        const li = document.createElement('li');
        li.textContent = `${todo.task} - ${todo.completed ? 'Completed' : 'Pending'}`;
        li.setAttribute('data-id', todo.id);

        // Group buttons in a container
        const buttonContainer = document.createElement('div');
        buttonContainer.style.display = 'flex';
        buttonContainer.style.gap = '10px';

        if (!todo.completed) {
            const completeButton = document.createElement('button');
            completeButton.textContent = 'Complete';
            completeButton.addEventListener('click', () => completeToDo(todo.id));
            buttonContainer.appendChild(completeButton);
        } else {
            const undoButton = document.createElement('button');
            undoButton.textContent = 'Undo';
            undoButton.addEventListener('click', () => undoComplete(todo.id));
            buttonContainer.appendChild(undoButton);
        }

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => deleteToDo(todo.id));
        buttonContainer.appendChild(deleteButton);

        li.appendChild(buttonContainer);
        todoList.appendChild(li);
    });
}

// Mark a To-Do as Complete
async function completeToDo(id) {
    await fetch(`${apiUrl}/${id}?completed=true`, { method: 'PUT' });
    loadToDos(); // Refresh the list
}

// Undo a Completed To-Do
async function undoComplete(id) {
    await fetch(`${apiUrl}/${id}?completed=false`, { method: 'PUT' });
    loadToDos(); // Refresh the list
}

// Delete a To-Do
async function deleteToDo(id) {
    await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
    loadToDos(); // Refresh the list
}

// Load To-Dos on page load
loadToDos();
