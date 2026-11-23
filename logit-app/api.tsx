const url = "http://localhost:8080";

type RegisterResult = { success: true } | { success: false; error: string };
type LoginResult =
  | { success: true; token: string }
  | { success: false; error: string };

export const registerAccount = async (
  email: string,
  password: string,
  timezone: string,
): Promise<RegisterResult> => {
  try {
    const res = await fetch(`${url}/auth/register`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: email,
        password: password,
        timezone: timezone,
      }),
    });

    if (!res.ok) {
      const message = await res.text();

      if (res.status === 409) {
        return { success: false, error: "Email already exists" };
      }

      return {
        success: false,
        error: `Request failed with status ${res.status}`,
      };
    }

    return { success: true };
  } catch (error) {
    console.error(error);
    return { success: false, error: "Could not reach the server" };
  }
};

export const loginAccount = async (
  email: string,
  password: string,
): Promise<LoginResult> => {
  try {
    const res = await fetch(`${url}/auth/login`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: email,
        password: password,
      }),
    });

    if (!res.ok) {
      const message = await res.text();

      if (res.status === 401) {
        return { success: false, error: "Wrong email or password" };
      }

      return {
        success: false,
        error: `Request failed with status ${res.status}`,
      };
    }

    const data = await res.json();
    const token = data.accessToken;
    return { success: true, token: token };
  } catch (error) {
    console.error(error);
    return { success: false, error: "Could not reach the server" };
  }
};
