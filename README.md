# Ascendion Click Counter Application

This is a full-stack application featuring a React frontend and a Spring Boot backend. The application allows a user to enter their name, click a button, and see a counter that increments with each click. The backend validates the user's name to ensure it meets specific criteria.

## Features

- **React Frontend**: A simple and responsive UI built with React and Vite.
- **Spring Boot Backend**: A robust backend providing a RESTful API.
- **Name Validation**: Both frontend and backend validation to ensure the user's name contains only letters and is at least two characters long.
- **Click Counter**: A counter that increments with each successful button click.
- **Dockerized**: The entire application is containerized with Docker and can be run with a single Docker Compose command.

## How to Run the Application

This project is fully containerized and can be run easily using Docker and Docker Compose.

### Prerequisites

- [Docker](https://www.docker.com/products/docker-desktop) installed on your machine.

### Running with Docker Compose

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/varya1441/test-ascendion.git
    cd test-ascendion
    ```

2.  **Run Docker Compose**:
    ```bash
    docker-compose up --build
    ```

    This command will build the Docker images for both the frontend and backend and start the containers.

### Accessing the Application

Once the containers are running, you can access the application and its services at the following ports:

- **Frontend Application**: [http://localhost:3000](http://localhost:3000)
  - This is the main application interface where you can interact with the input field and button.

- **Backend API**: [http://localhost:8082](http://localhost:8082)
  - The Spring Boot backend is accessible at this port. The primary endpoint is `/api/click`.

## Project Structure

- **`ascendion-ui/`**: Contains the React frontend application.
- **`src/`**: Contains the Spring Boot backend application source code.
- **`Dockerfile`**: The Dockerfile for the Spring Boot backend.
- **`ascendion-ui/Dockerfile`**: The Dockerfile for the React frontend.
- **`docker-compose.yml`**: The Docker Compose file that orchestrates the entire application.
