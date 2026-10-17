# local-web-server

Embedded local web server service.

## Owns

- Local web server contract.
- NanoHTTPD-backed default implementation.
- Optional Hilt binding for server construction.

## Boundaries

- Do not add app-specific routes, secrets, or authorization policy here.
- Do not expose network trust decisions directly from this module.
- Keep route/content ownership in consuming modules.

## Usage

Use this module when a consumer needs a small local HTTP server abstraction.
