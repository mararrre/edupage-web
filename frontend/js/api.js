import { BASE_URL, USE_MOCK } from "./config.js";

// МОК для теста без backend (потом надо выключить USE_MOCK)
function mockLogin(email, password) {
  if (!email || !password) {
    const err = new Error("EMPTY_FIELDS");
    err.status = 400;
    throw err;
  }
  // фейк токен
  return { token: "MOCK_JWT_TOKEN", role: "ADMIN" };
}

export async function apiLogin(email, password) {
  if (USE_MOCK) return mockLogin(email, password);

  const res = await fetch(`${BASE_URL}/api/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
  });

  let data = null;
  try { data = await res.json(); } catch (_) {}

  if (!res.ok) {
    const err = new Error(data?.message || "LOGIN_FAILED");
    err.status = res.status;
    throw err;
  }

  if (!data?.token) throw new Error("BAD_RESPONSE_TOKEN_MISSING");
  return data; // { token, role }
}
