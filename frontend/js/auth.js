import { apiLogin } from "./api.js";

const TOKEN_KEY = "edupage_token";
const ROLE_KEY = "edupage_role";

export function setAuth(token, role) {
  localStorage.setItem(TOKEN_KEY, token);
  localStorage.setItem(ROLE_KEY, role || "");
}

export function getToken() {
  return localStorage.getItem(TOKEN_KEY);
}

export function getRole() {
  return localStorage.getItem(ROLE_KEY);
}

export function logout() {
  localStorage.removeItem(TOKEN_KEY);
  localStorage.removeItem(ROLE_KEY);
  window.location.href = "login.html";
}

export async function login(email, password) {
  const { token, role } = await apiLogin(email, password);
  setAuth(token, role);
  return { role };
}
