import server from "./server";

export function getUsers() {
  return server.get("/users")
}