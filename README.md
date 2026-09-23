## Incognito Mods

The mod lets you control the minecraft:mod_list packet. It is a new custom payload added in snapshot 26.4 that reports your installed client mods to the server.

Vanilla clients send an empty list by default and mod loaders may fill it with every mod you have installed. This mod sits on the connection level and decides what actually leaves your client.

The mod is client side only. It is configurable in game through Simple Config Lib with ModMenu on Fabric. It also works with sensible defaults without SCL installed.

Available modes:

- **Passthrough** sends the list as is
- **Empty** always sends an empty list so you look exactly like a vanilla client
- **Custom** sends your own list of mod entries instead