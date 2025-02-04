import pygame

# Inicializar
pygame.init()

tamanho_tela = (800, 800)
tela = pygame.display.set_mode(tamanho_tela)
pygame.display.set_caption("Brick Breacke")

tamanho_Bola = 15
bola = pygame.Rect(100, 500, tamanho_Bola, tamanho_Bola)
tamanho_Jogador = 100
jogador = pygame.Rect(0, 750, tamanho_Jogador, 15)

qnt_blocos_linha = 8
qnt_linha_bloco = 5
qnt_total_blocos = qnt_blocos_linha * qnt_linha_bloco


def criar_blocos(qnt_blocos_linha, qnt_linha_bloco):
    blocos = []
    altura_tela = tamanho_tela[1]
    largura_tela = tamanho_tela[0]
    distancia_entre_bloco = 5
    largura_bloco = largura_tela / 8 - distancia_entre_bloco
    altura_bloco = 15
    distancia_entre_linhas = altura_bloco + 10

    bloco = []
    #criar bloco
    for j in range (qnt_linha_bloco):
        for i in range(qnt_blocos_linha):
            #criar o bloco
            bloco = pygame.Rect ( i * (largura_bloco + distancia_entre_bloco), j * distancia_entre_linhas, largura_bloco, altura_bloco)
            # adicionar o bloco na lista de blocos
            blocos.append(bloco)
    return blocos

cores = {
    "branco": (255, 255, 255),
    "preto": (0, 0, 0),
    "amarela": (255, 255, 0),
    "azul": (0, 0, 255),
    "verde": (0, 255, 0)
}

fim_Jogo = False
pontuação = 0
movimento_bola = [1, -1]

# criar funções do jogo
def mover_jogador(evento):
    if evento.type == pygame.KEYDOWN:
        if evento.key == pygame.K_RIGHT:
            if (jogador.x + tamanho_Jogador) < tamanho_tela[0]:
                jogador.x = jogador.x + 5
        if evento.key == pygame.K_LEFT:
            if jogador.x > 0:
               jogador.x = jogador.x - 5
                
def mover_bola(bola):
    movimento = mover_bola
    bola.x = bola.x + movimento[0]
    bola.y = bola.y + movimento[1]

   # colisão com as paredes
   # x = altura | y = largura
    if bola.x <= 0:
        movimento_bola[0] = - movimento[0]
    if bola.y <= 0:
        movimento_bola[1] = - movimento[1]
    if bola.x + tamanho_Bola >= tamanho_tela[0]:
        movimento[0] = - movimento[0]
    if bola.y + tamanho_Bola >= tamanho_tela[1]:
        movimento = [None]

# colisão com o jogador
    if jogador.collidepoint(bola.x, bola.y):
        movimento[1] = - movimento[1]

# colisão com os blocos
    if blocos.collidepoint(bola.x, bola.y):
        movimento[1] = - movimento[1]
        blocos.remove(blocos)
    return movimento

#pontuação usuario
def atualizar_pontuação(pontuação):
    font = pygame.font.Font(None, 30)
    texto = font.render(f"Pontuação: {pontuação}", 1, cores["amarala"])
    tela.blit(texto, (0, 780))
    if pontuação >= qnt_total_blocos:
        return True
    else:
        return False

# desenhar funções
def desenhar_inicio_jogo():
    tela.fill(cores["preto"])
    pygame.draw.rect(tela, cores["azul"], jogador)
    pygame.draw.rect(tela, cores["branco"], bola)

def desenhar_blocos(blocos):
    for bloco in blocos:
        pygame.draw.rect(tela, cores["verde"], bloco)

desenhar_inicio_jogo()
blocos = criar_blocos(qnt_blocos_linha, qnt_linha_bloco)
desenhar_blocos(blocos)

# criar loop infinito
while not fim_Jogo:
    desenhar_blocos (blocos)
    fim_jogo = atualizar_pontuação(qnt_total_blocos - len(blocos))
    desenhar_inicio_jogo()
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            fim_Jogo = True
mover_jogador(evento)
movimento_bola = mover_bola(bola)
if not movimento_bola:
    fim_Jogo = True
pygame.time.wait(1)
pygame.display.flip()

pygame.quit()