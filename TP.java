private void Tp() {
        float x = ( float ) (xLocation + 0.5);
        float z = ( float ) (zLocation + 0.5);
        float y = world.getHighestBlockYAt((int)x, (int)z);

        Location loc = new Location(world, x, y+4, z, 0, 0);
        loc.getWorld().loadChunk(loc.getChunk());

        Location center = new Location(world, 0.5, 100, 0.5);

        double dX = loc.getX() - center.getX();
        double dY = loc.getY() - center.getY();
        double dZ = loc.getZ() - center.getZ();

        double vYaw = Math.atan2 (dZ, dX);
        double vPitch = Math.atan2 (Math.sqrt (dZ * dZ + dX * dX), dY) + Math.PI;

        double X = Math.sin (vPitch) * Math.cos (vYaw);
        double Y = Math.sin (vPitch) * Math.sin (vYaw);
        double Z = Math.cos (vPitch);

        Vector vector = new Vector(X, Z, Y);

        float yaw = player.getLocation().setDirection(vector).getYaw();
        loc = new Location(world, x, y+4, z, yaw, 0.0f);

        player.teleport(loc);
    }
